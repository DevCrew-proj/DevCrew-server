package com.example.devcrew.domain.contest.service;

import com.example.devcrew.domain.contest.converter.ContestConverter;
import com.example.devcrew.domain.contest.dto.response.GetContestDetailResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestListResponseDTO;
import com.example.devcrew.domain.contest.dto.response.GetContestOneResponseDTO;
import com.example.devcrew.domain.contest.entity.Contest;
import com.example.devcrew.domain.contest.entity.Sector;
import com.example.devcrew.domain.contest.repository.ContestRepository;
import com.example.devcrew.domain.member.entity.Member;
import com.example.devcrew.domain.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.devcrew.domain.contest.exception.ContestNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContestQueryServiceImpl implements ContestQueryService{

    private final ContestRepository contestRepository;

    // 공모전 전체 조회
    @Override
    public Page<GetContestOneResponseDTO> findAllContests(Pageable pageable) {
        Page<Contest> contests = contestRepository.findAll(pageable);
        if (contests.isEmpty()) {
            throw new ContestNotFoundException();
        }
        return contests.map(ContestConverter::toGetContestOneResponseDTO);
    }


    // 공모전 섹터별 조회
    @Override
    public Page<GetContestOneResponseDTO> findContestsBySector(Sector sector, Pageable pageable) {
        Page<Contest> contests = contestRepository.findBySector(sector, pageable);
        if (contests.isEmpty()) {
            throw new ContestNotFoundException();
        }
        return contests.map(ContestConverter::toGetContestOneResponseDTO);
    }


    // 페이징 및 최신순 정렬 처리
    @Override
    public GetContestListResponseDTO getContests(Sector sector, int page, int size, String sort, String order) {
        Sort.Direction direction;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sort));

        Page<GetContestOneResponseDTO> contestsPage;
        if (sector != null) {
            contestsPage = findContestsBySector(sector, pageable);
        } else {
            contestsPage = findAllContests(pageable);
        }

        List<GetContestOneResponseDTO> contests = contestsPage.stream().collect(Collectors.toList());
        return GetContestListResponseDTO.builder()
                .totalResult((int) contestsPage.getTotalElements())
                .contests(contests)
                .build();
    }


    // 공모전 상세 조회
    @Override
    public GetContestDetailResponseDTO findContestDetailById(Long contestId){
        Contest contest  = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);

        Member member = contest.getMember();
        if (member == null) {
            throw new MemberNotFoundException();
        }
        String name = member.getCompanyMember().getCeoName();
        System.out.println(name);
        return ContestConverter.toGetContestDetailResponseDTO(contest, member);
    }
}
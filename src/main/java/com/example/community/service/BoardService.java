package com.example.community.service;

import com.example.community.domain.entity.Board;
import com.example.community.domain.request.BoardRequest;
import com.example.community.domain.request.MemberUpdateRequest;
import com.example.community.domain.response.BoardResponse;
import com.example.community.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //여기서 만약에 데이터베이스를 나누면 Community에 Board 저장하도록 api 날려야함
    public void save(BoardRequest boardRequest, Long communityId){
        boardRepository.save(boardRequest.toEntity(communityId));
    }

    public void updateBoard(BoardRequest boardRequest, Long boardId){
        //예외처리 필요하긴 함
        Board board = boardRepository.findById(boardId).get();
        board.setContent(boardRequest.getContent());
        board.setContent(boardRequest.getContent());
        board.setTitle(boardRequest.getTitle());
        board.setMemberImage(boardRequest.getMemberImage());
    }

    //유저가 업데이트 하면 게시판의 멤버 정보도 업데이트 돼야함
    //동적쿼리까지 쓸 필요는 없을 것 같아서 하드코딩함. 하지만 멤버 정보를 더 늘린다면 하드코딩은 부담스럽고 동적쿼리를 써야할 것 같음(mybatis, queryDsl)
    public void updateBoardMember(MemberUpdateRequest memberUpdateRequest, Long memberId) throws Exception {
        if (memberUpdateRequest.getMemberImage() != null && memberUpdateRequest.getMemberName() !=null ){
            boardRepository.updateBoardMemberImageAndMemberName(memberUpdateRequest.getMemberName(), memberUpdateRequest.getMemberImage(), memberId);
        } else if (memberUpdateRequest.getMemberImage()!=null && memberUpdateRequest.getMemberName() ==null) {
            boardRepository.updateBoardMemberImage(memberUpdateRequest.getMemberImage(),memberId);
        } else if (memberUpdateRequest.getMemberImage()==null && memberUpdateRequest.getMemberName() != null) {
            boardRepository.updateBoardMemberName(memberUpdateRequest.getMemberName(), memberId);
        } else {
            throw new Exception("NULL REQUEST");
        }
    }


    public Page<BoardResponse> findByCommunityId(Long communityId, PageRequest pageRequest){
        return boardRepository.findByCommunity(communityId, pageRequest);
    }


    public void deleteByBoardId(Long boardId){
        boardRepository.deleteById(boardId);
    }


}

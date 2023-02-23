package project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import project.dto.DiaryDto;
import project.dto.GoalDto;
import project.dto.MoodDto;
import project.dto.ShareMemberDto;
import project.dto.ShareRoomDto;
import project.dto.WeatherDto;

@Mapper
public interface DiaryMapper {

	// 1. 개인 일기 목록 조회
	 List<DiaryDto> selectPrivateList(String memberId) throws Exception;
	 
	 // 1-1. 날짜별 개인 일기 목록 조회
	 public List<DiaryDto> selectPrivateListByDt(@Param("memberId") String memberId,@Param("createdDt") String createdDt) throws Exception;

	 // 2, 9. 개인/교환 일기 작성 화면 - 기분, 날씨 선택
	 List<WeatherDto> weatherList() throws Exception;
	 List<MoodDto> moodList() throws Exception;

	 // 3. 개인 일기 작성
	 int insertPrivate(DiaryDto diaryDto) throws Exception;
	 
	 // 4. 개인 일기 상세 조회
	 DiaryDto selectPrivateDetail(int diaryId) throws Exception;
	 
	 // 5. 개인 일기 수정
	 int updatePrivate(DiaryDto diaryDto) throws Exception;
	 
	 // 6. 개인 일기 삭제
	 int deletePrivate(int diaryId) throws Exception;
	 
	 // 7. 교환 일기 그룹 목록 조회
	 List<ShareRoomDto> selectPublicList() throws Exception;
	 
	 // 8. 교환 일기 목록 조회
	 List<Map<String, Object>> selectPublicShareList(int shareRoomId) throws Exception;
	 
	 // 8-1. 날짜별 교환 일기 목록 조회
	 List<Map<Object, Object>> selectPublicShareListByDt(@Param("shareRoomId") int shareRoomId, @Param("createdDt") String createdDt) throws Exception;
	 
	 // 10. 교환 일기 작성
	 int insertPublic(DiaryDto diaryDto) throws Exception;
	 
	 // 11. 교환 일기 상세 조회
	 List<DiaryDto> selectPublicDetail(@Param("shareRoomId") int shareRoomId, @Param("createdDt") String createdDt) throws Exception;
	 
	 // 12. 교환 일기 그룹 추가
	 int addGroup(ShareRoomDto shareRoomDto) throws Exception;
	
	 // 13. 교환 일기 멤버 추가
	 int addGroupNext(ShareMemberDto shareMemberDto);

	 // 17. 개인 목표 목록 조회
	 List<GoalDto> selectGoalList(@Param("memberId")String memberId, @Param("goalDate")String goalDate) throws Exception;
	 
	 // 18. 개인 목표 쓰기
	 int insertGoal(GoalDto goalDto) throws Exception;
	 
	 // 19. 개인 목표 수정
	 int updateGoal(GoalDto goalDto) throws Exception;
	
	 
}

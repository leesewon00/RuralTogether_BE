package landvibe.test;

public enum RegionName {
    // 총선 지역구 명으로 작성하였습니다.
    인천("인천"), 서울("서울"), 경기("경기"),

    강원("강원"),

    충남("충남"), 충북("충북"), 세종("세종"), 대전("대전"),

    전북("전북"), 전남("전남"), 광주("광주"),

    경북("경북"), 경남("경남"), 대구("대구"), 부산("부산"), 울산("울산"),

    제주("제주");

    public String message;

    RegionName(String message) {
        this.message = message;
    }
}

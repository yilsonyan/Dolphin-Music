package cn.jd.springIoC;

public class TestIoc {

    @Autowired
    StudyService studyService;

    public void testIoC(){
        studyService.study();
    }

}

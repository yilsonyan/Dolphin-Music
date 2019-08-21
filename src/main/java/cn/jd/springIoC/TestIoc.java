package cn.jd.springIoC;

public class TestIoc {

    @MyAutowired
    StudyService studyService;

    public void testIoC(){
        studyService.study();
    }

}

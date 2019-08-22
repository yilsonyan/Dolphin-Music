package cn.jd.restfull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CmsPageController {

    //@Override
    // http://localhost:8080/page/1/2
    @GetMapping("page/{page}/{size}")   //@GetMapping等同于以Get方式访问的@RequestMapping
    public Object findList(@PathVariable("page") int page, @PathVariable("size") int size) {
        return page+size;
    }

}


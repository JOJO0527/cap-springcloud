package cn.kilog.cap.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 页面跳转controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 */
@Controller
public class PageController {

    /**
     * 打开首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    /**
     * 展示其他页面
     * <p>Title: showpage</p>
     * <p>Description: </p>
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/haha")
    @ResponseBody
    public String showpage1() {
        return "successfule";

    }
}

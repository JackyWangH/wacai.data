package com.Haoxuan.wacai.web.controller;
import com.File.Wang.Web.dao.WhxPortChartMapper;
import com.File.Wang.Web.dataobject.WhxPortChart;
import com.Haoxuan.wacai.web.Service.RecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Haoxuan.wacai.web.Model.User;
import java.util.List;
import java.util.Map;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;//端口类对象
    @Autowired
    private WhxPortChartMapper whxPortChartMapper;
    @RequestMapping("/back")
    public String index(){
        return "index";
    }//返回界面

    @RequestMapping("/search-index")
    public String searchInfo(){
        return "search-index";
    }

    //接收主键并查询数据
    @RequestMapping("/search-result")//model向前端传递参数值
    public String search(@RequestParam("phone") String phone, Model model){
        Map <String, com.Haoxuan.wacai.web.Model.User> userMap = recordService.query();//用Map来接收Excel表里的数据
        User user = (User) userMap.get(phone);//user得到Key值
        model.addAttribute("user",user);//user作为前端传递数据的媒介
        return "search-result";
    }

    //根据page的值进行分页展示所有数据
    @RequestMapping("/selectAll/page={page}")//@PathVariable可以用来映射URL中的占位符到目标方法的参数中
    public String selectAllPort(Model model, @PathVariable(name = "page")int page){
        int size=20;//每页容量
        int offset=size*(page-1);
        List<WhxPortChart> lists =whxPortChartMapper.selectByPagination(offset,size);//数据存入lists
        int length = whxPortChartMapper.countRecords();//全部记录条数
        //判断记录的页数
        if (length%size!=0){
            length = length/size+1;
        }else{
            length = length/size;
        }
        model.addAttribute("lists",lists);
        model.addAttribute("length",length);//页数
        return "search-result";
    }

    //插入一条数据到数据库
    @RequestMapping("/insert")
    @ResponseBody
    public String insertPort(@RequestParam("name")String name,
                             @RequestParam("phoneNum")String phone,
                             @RequestParam("port")String port,
                             @RequestParam("password")String password){
        //后端通过input里name的value值来传递参数
        WhxPortChart whxPortChart = new WhxPortChart();
        whxPortChart.setName(name);
        whxPortChart.setPhone(phone);
        whxPortChart.setPort(port);
        whxPortChart.setPassword(password);
        whxPortChartMapper.insert(whxPortChart);
        return "插入成功";
    }

    //插入excel中所有数据。类似初始化数据，不提供页面操作
    @RequestMapping("/insertAll")
    @ResponseBody
    public String insertAllPort(){
        Map <String, com.Haoxuan.wacai.web.Model.User> userMap = recordService.query();
        if (userMap==null){
            return "插入失败！";
        }
        userMap.forEach(
                (k,v)->{
                    WhxPortChart whxPortChart = new WhxPortChart();
                    BeanUtils.copyProperties(whxPortChart,userMap);//数据存入方法,将usermap里数据导入到POJO类对象里去，作为插入数据库对象
                    whxPortChartMapper.insert(whxPortChart);
                }
        );
        return "插入成功";
    }
}

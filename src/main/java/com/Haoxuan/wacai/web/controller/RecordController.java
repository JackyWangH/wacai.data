package com.Haoxuan.wacai.web.controller;
import com.File.Wang.Web.dataobject.WhxPortChart;
import com.Haoxuan.wacai.web.Service.RecordService;
import com.Haoxuan.wacai.web.dao.WhxPortChartMapper;
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
    public String meet(){

        return "search-first";
    }//返回界面

    @RequestMapping("/search/first")
    public String searchFirst(){

        return "search-first";
    }

    @RequestMapping("/search/second")//model向前端传递参数值
    public String search(@RequestParam("phone") String phone, Model model){
        Map <String,User> userMap = recordService.query();//用Map来接收Excel表里的数据
        User user = userMap.get(phone);//user得到Key值
        model.addAttribute("user",user);//user作为前端传递数据的媒介
        return "search-second";
    }

    @RequestMapping("/selectall/page={page}")
    public String selectall(Model model, @PathVariable(name = "page")int page){
        int size=5;
        int offset=size*(page-1);
        List<WhxPortChart> lists = whxPortChartMapper.selectByPagination(offset,size);
        int length = whxPortChartMapper.countRecords();
        if (length%size!=0){
            length = length/size+1;
        }else{
            length = length/size;
        }
        model.addAttribute("lists",lists);
        model.addAttribute("length",length);//页数
        return "search-third";
    }
    @RequestMapping("/updata")
    public String updata(@RequestParam("name")String name,
                         @RequestParam("phone")String phone,
                         @RequestParam("port")String port,
                         @RequestParam("password")String password)  {
        WhxPortChart whxPortChart = new WhxPortChart();
        whxPortChart.setName(name);
        whxPortChart.setPhone(phone);
        whxPortChart.setPort(port);
        whxPortChart.setPassword(password);
        whxPortChartMapper.updateByPhone(whxPortChart);

        return "yes-suc";
    }

    @RequestMapping("/insert")
    public String insertPort(@RequestParam("name")String name,
                             @RequestParam("phone")String phone,
                             @RequestParam("port")String port,
                             @RequestParam("password")String password,Model model){
        //后端通过input里name的value值来传递参数
        WhxPortChart whxPortChart = new WhxPortChart();
        whxPortChart.setName(name);
        whxPortChart.setPhone(phone);
        whxPortChart.setPort(port);
        whxPortChart.setPassword(password);
        whxPortChartMapper.insert(whxPortChart);
        model.addAttribute("user-insert",whxPortChart);
        if(whxPortChart==null){
            return "updata-error";
        }else{
        return "yes-suc";}
    }
    @RequestMapping(path = "/delete")
    public String delete(@RequestParam("phone")String phone){
        whxPortChartMapper.deleteByOne(phone);
        return "delete";
    }

    @RequestMapping("/insertall")
    public String insertAllPort(){
        Map <String,User> userMap = recordService.query();
        if (userMap==null){
            return "插入失败！";
        }
        userMap.forEach(
                (k,v)->{
                    WhxPortChart whxPortChart = new WhxPortChart();
                    BeanUtils.copyProperties(v,whxPortChart);//数据存入方法,将usermap里数据导入到POJO类对象里去，作为插入数据库对象
                    whxPortChartMapper.insert(whxPortChart);
                }
        );
        return "yes-suc";

    }
    @RequestMapping("/deleteall")
    public String deleteAllPort(){
        Map <String,User> userMap = recordService.query();
        if (userMap==null){
            return "删除失败！";
        }
        userMap.forEach(
                (k,v)->{
                    WhxPortChart whxPortChart = new WhxPortChart();
                    BeanUtils.copyProperties(v,whxPortChart);//数据存入方法,将usermap里数据导入到POJO类对象里去，作为插入数据库对象
                    whxPortChartMapper.deleteByall(whxPortChart);
                }
        );
        return "yes-suc";
}
}

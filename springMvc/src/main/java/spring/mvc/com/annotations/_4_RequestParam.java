package spring.mvc.com.annotations;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequestMapping("requestParam ")
/**
 * Then try following urls:
http://localhost:8080/spring-mvc-query-param/employees?dept=IT
http://localhost:8080/spring-mvc-query-param/employees?state=NC
http://localhost:8080/spring-mvc-query-param/employees?dept=IT&state=NC
http://localhost:8080/spring-mvc-query-param/employees?dept=IT&state=NC
http://localhost:8080/spring-mvc-query-param/employees/234/paystubs?months=5
http://localhost:8080/spring-mvc-query-param/employees/234/paystubs?startDate=2000-10-31&endDate=2000-10-31
http://localhost:8080/spring-mvc-query-param/employees/234/report
http://localhost:8080/spring-mvc-query-param/employees/234/report
http://localhost:8080/spring-mvc-query-param/employees/234/report?project=mara
http://localhost:8080/spring-mvc-query-param/employees/234/messages?sendBy=mgr&date=20160210
 * @author Mohamed.Aljazwiee
 *
 */
public class _4_RequestParam {

    private static final Logger LOGGER = Logger.getLogger(_4_RequestParam.class.getName());

    @RequestMapping(params = "dept")
    public String handleEmployeeRequestByDept (@RequestParam("dept") String deptName, Model map) {
        LOGGER.info("employee request by dept : " + deptName);
        map.addAttribute("msg", "employee " + deptName);
        return "my-page";
    }

    /**
     * This won't be mapped if code is not compiled with debugging information
     */
    @RequestMapping(params = "state")
    public String handleEmployeeRequestByArea (@RequestParam String state, Model map) {
        LOGGER.info("employee request by state : " + state);
        map.addAttribute("msg", "Employee request by area: " + state);
        return "my-page";
    }

    @RequestMapping(params = {"dept", "state"})
    public String handleEmployeeRequestByDept (@RequestParam("dept") String deptName,
                                               @RequestParam("state") String stateCode, Model map) {
        LOGGER.info("Employee request by dept and state code : " + deptName + ", " + stateCode);
        map.addAttribute("msg", "Employee request by dept and state code : " + deptName + ", " +
                            stateCode);
        return "my-page";
    }


    @RequestMapping("{id}/messages")
    public String handleEmployeeMessagesRequest (@PathVariable("id") String employeeId,
                                                 @RequestParam Map<String, String> queryMap,
                                                 Model model) {
        LOGGER.info("employee request by id and query map : " + employeeId + ", " + queryMap
                            .toString());
        model.addAttribute("msg", "employee request by id and query map : " + employeeId + ", " +
                            queryMap.toString());
        return "my-page";
    }

    @RequestMapping(value = "{id}/paystubs", params = "months")
    public String handleRequest4 (@PathVariable("id") String employeeId,
                                  @RequestParam("months") int previousMonths, Model model) {
        LOGGER.info("employee request by id and paystub for the previous months : " + employeeId
                                        + ", " + previousMonths);
        model.addAttribute("msg",
                           "employee request by id and paystub previous months : " + employeeId +
                                               "," +
                                               " " +
                                               previousMonths);
        return "my-page";
    }

    
    @RequestMapping(value = "{id}/paystubs", params = {"startDate", "endDate"})
    public String handleRequest4 (
                        @PathVariable("id") String employeeId,
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam
                                            ("startDate") LocalDate startDate,
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam
                                            ("endDate") LocalDate endDate,
                        Model model) {

        LOGGER.info("employee request by id and paystub dates : " +
                                        employeeId + ", " + startDate + ", " + endDate);
        model.addAttribute("msg",
                           "employee request by id and paystub dates : " + employeeId +
                                               ", " + startDate + ", " + endDate);
        return "my-page";
    }

    
    @RequestMapping(value = "{id}/report")
    public String handleEmployeeReportRequest (@PathVariable("id") String id,
                                               @RequestParam(value = "project", required = false)
                                               String projectName,
                                               Model model) {

        LOGGER.info("employee report request by id and project name : " + id + ", " + projectName);
        model.addAttribute("msg", "employee report request by id and project name : " + id + ", " +
                            projectName);
        return "my-page";
    }
}

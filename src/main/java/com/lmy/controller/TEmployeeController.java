package com.lmy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmy.dto.PageResult;
import com.lmy.entity.TClockInfo;
import com.lmy.entity.TEmployee;
import com.lmy.service.TEmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *  前端控制器
 * @since 2020-06-17
 */
@Controller
public class TEmployeeController {

    @Autowired
    private TEmployeeService tEmployeeServiceImpl;

    /**
     * 展示新增页面
     * @return
     */
    @RequestMapping("/employeeInfo")
    public String showEmployeeInfo() {
        return "AddEmployeeInfo";
    }

    /**
     * 分页显示员工信息
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/showEmployee")
    public String showAllAttendance(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "6") Integer size,
                                    Model model) {

        PageResult<TEmployee> tClockInfoPage = tEmployeeServiceImpl.findByPage(page, size);
        model.addAttribute("EmployeeInfoList", tClockInfoPage.getList());
        model.addAttribute("currPage", tClockInfoPage.getCurrPage());
        model.addAttribute("totalPage", tClockInfoPage.getTotalPage());
        model.addAttribute("totalCount", tClockInfoPage.getTotalCount());
        model.addAttribute("pageSize", tClockInfoPage.getPageSize());

        return "showEmployee";
    }

    //新增员工信息
    @PostMapping("/AddAdmin")
    public String updateAndAddAdmin(TEmployee employee){

            if (employee == null){
                return "employeeInfo";
            }
            int i = this.tEmployeeServiceImpl.addAdmin(employee);

            if (i == 0){
                return "AddEmployeeInfo";
            }
            return "redirect:/showEmployee";
        }

    //展示修改员工信息页面
    @GetMapping("/showUpdateAdmin")
    public String showUpdate(Integer employeeId,Model model){
        TEmployee tEmployee = this.tEmployeeServiceImpl.showById(employeeId);
        model.addAttribute("employee",tEmployee);
        return "updateEmployeeInfo";
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @PostMapping("updateAdmin")
    public String updateAdmin(TEmployee employee){

        int index = this.tEmployeeServiceImpl.updateAdmin(employee);

        if (index == 0){
            return "updateEmployeeInfo";
        }
        return "redirect:/showEmployee";
    }

    /**
     * 删除员工信息
     * @param employeeId
     * @return
     */
    @GetMapping("/deleteAdmin")
    public String deleteAdmin(Integer employeeId){
       this.tEmployeeServiceImpl.deleteAdmin(employeeId);
       return "redirect:/showEmployee";
    }
}


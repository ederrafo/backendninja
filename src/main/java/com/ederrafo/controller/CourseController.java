package com.ederrafo.controller;


import com.ederrafo.entity.Course;
import com.ederrafo.service.CourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

@Controller
@RequestMapping("/courses")
public class CourseController {

    //Logging
    private static final Log LOG = LogFactory.getLog(CourseController.class);

    @Autowired
    private CourseService courseService;


    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView modelAndView = new ModelAndView("courses/all");
        modelAndView.addObject("courses", courseService.all());
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
        return modelAndView;
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
        model.addAttribute("course", new Course());

        return "courses/add";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("course") Course course) {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod + " Params :" + course.toString());
        courseService.store(course);
        return  "redirect:/courses/all";
    }

    @GetMapping("/addUpload")
    public String addUpload()
    {

        return "courses/addUpload";
    }

    @PostMapping("/upload")
    // public String uploadRead(Model model, MultipartFile multipartFile) throws IOException {

    public String uploadRead(@RequestParam("file") MultipartFile multipartFile) throws Exception{

        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("From ->" + nameofCurrentMethod);
        Path tempDir = Files.createTempDirectory("");
        File tempFile = tempDir.resolve(multipartFile.getOriginalFilename()).toFile();

        //Workbook workbook = WorkbookFactory.create(tempFile);
        Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream());

        LOG.info("Workbook has  " + workbook.getNumberOfSheets() + " sheets :");

        /*
           =============================================================
           Iterating over all the sheets in the workbook (Multiple ways)
           =============================================================
        */

        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        rowIterator.next();

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            LOG.info("name  " + row.getCell(0).getStringCellValue() + "\t");
            LOG.info("description  " + row.getCell(1).getStringCellValue() + "\t");
            LOG.info("hours  " + row.getCell(2).getNumericCellValue () + "\t");
            LOG.info("price  " + row.getCell(3).getNumericCellValue() + "\t");
            Course course = new Course();
            course.setName(row.getCell(0).getStringCellValue());
            course.setDescription(row.getCell(1).getStringCellValue());
            course.setPrice(new BigDecimal(row.getCell(3).getNumericCellValue()));
            course.setHours((int) row.getCell(2).getNumericCellValue ());
            courseService.store(course);

        }



        workbook.close();




        return "courses/uploadRead";


    }

}

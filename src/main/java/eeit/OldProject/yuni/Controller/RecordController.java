package eeit.OldProject.yuni.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import eeit.OldProject.yuni.Service.RecordService;

@Controller
public class RecordController{
    @Autowired
    private RecordService recordService;
   
}

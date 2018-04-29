package org.innopolis.javaEE.fileIO.controller;

import org.innopolis.javaEE.fileIO.service.interfaces.ImportService;
import org.innopolis.javaEE.fileIO.service.util.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


@Controller
@RequestMapping("/import")
public class ImportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportController.class);

    private final ImportService importService;

    @Autowired
    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String importGetRequest(){
        LOGGER.error("Get request for import file in system");
        return "import";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String index1GetRequest(@RequestParam("file") MultipartFile file) throws IOException {
        LOGGER.error("Getting input file");
        try {
            importService.processFile(convert(file));
        } catch (ServiceException e) {
            LOGGER.error("Service exception has occured. {}", e.getMessage());
        }
        return "import";
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}

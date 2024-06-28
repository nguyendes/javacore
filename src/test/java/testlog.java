/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maytinh
 */
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class testlog {
    // Tạo logger
    static final Logger logger = Logger.getLogger(testlog.class);

    public static void main(String[] args) {
        // Cấu hình Log4j bằng file properties
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        // Kiểm tra cấu hình log
        if (logger.isDebugEnabled()) {
            logger.debug("Log4j được cấu hình thành công!");
        }

        // Ghi log ở các mức độ khác nhau
        logger.debug("Đây là thông báo debug");
        logger.info("Đây là thông báo info");
        logger.warn("Đây là thông báo warning");
        logger.error("Đây là thông báo error");
        logger.fatal("Đây là thông báo fatal");
    }
}




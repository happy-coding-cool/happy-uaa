package cool.happycoding.uaa;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动类
 * </p>
 *
 * @author happycoding@aliyun.com
 * @since 2021-06-10 17:15:30
 */
@SpringBootApplication
@MapperScan("cool.happycoding.uaa.**.mapper")
public class HappyUaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(HappyUaaApplication.class, args);
    }
}

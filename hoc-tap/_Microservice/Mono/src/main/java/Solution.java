import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class Solution {

    /*
     * Mono được chia làm 2 quá trình.
     * 1. là khởi tạo
     * 2. là đăng ký bằng subscribe.
     */

    /*
     * flat sinh ra để nối 2 Mono lại với nhau,
     * mono subscribe -> mono 1 subscribe
     * chương trình sẽ lần lượt thực hiện hàm onNext theo thứ tự đăng ký.
     * bất kỳ lỗi xảy ra ở đâu đều dẫn đến toàn mono liên quan thất bại.
     */
    @Test
    public void monoFlat(){
        Mono<String> mono = Mono.just("hoang").log()
                .flatMap(content->{
                    System.out.println(content);
                    Mono<String> mono1 = (1 == 1)? Mono.just("nguyen") : Mono.error(new Exception("loi roi"));
                    return mono1;
                }).log();
        mono.subscribe(System.out::println);
    }

    /*
     * then sinh ra để kiểm tra tính logic của các câu lệnh.
     * Mono trong đối số của then chỉ được khởi tạo và trả về nếu như Mono sử dụng hàm then()
     * khởi tạo thành công.
     */
    @Test
    public void monoThen1(){
        Mono<?> falseMono = Mono.just("hoang").log()
                .then(Mono.error(new Exception("loi roi"))).log();
        Mono<?> trueMono = Mono.just("hoang").log()
                .then(Mono.just("nguyen")).log();

        Mono<?> mono = (1==1)?trueMono:falseMono;
        mono.subscribe(System.out::println);
    }

    @Test
    public void monoThen2(){
        Mono<?> errorMono = Mono.error(new Exception("loi roi")).log()
                .then(Mono.just("hoang")).log();
        errorMono.subscribe();
    }

    @Test
    public void superMono(){
        Mono<String> mono = Mono.just("hoang").log();
        mono.subscribe(content ->{
            Mono<String> child = (1==0)?Mono.just("nguyen").log():Mono.error(new Exception("loi roi"));
            child.subscribe();
        });
    }
}

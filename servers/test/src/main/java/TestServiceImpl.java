import org.yabo.common.Code;
import org.yabo.common.Result;
import org.yabo.service.test.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public Result<String> test(String in) {
        Result<String> result = new Result<>();
        result.setCode(Code.SUCCESS);
        result.setData("TestServiceImpl response:" + in);
        return result;
    }
}

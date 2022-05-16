package co.com.sergiofranko.usecase.util;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class UtilUseCase {

    public static Map<String, Object> responseResult(int success, String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

}

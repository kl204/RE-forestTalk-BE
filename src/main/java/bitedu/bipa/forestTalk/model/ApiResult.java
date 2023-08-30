package bitedu.bipa.forestTalk.model;

import lombok.Data;
import java.util.List;

@Data
public class ApiResult {
	private String result = "SUCCESS";
    private String resultMsg = "";
    private List data;
    private Object voData;
    private String strData;
}

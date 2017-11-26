import com.goebl.david.Response;
import com.goebl.david.Webb;
import entity.WorkLog;
import org.json.JSONObject;
import service.DateService;

import java.util.Base64;

public class Request {
    private String encoding = Base64.getEncoder().encodeToString(("diarselimi92:@bitbucket#diar$").getBytes());

    public Request(String uri, WorkLog workLog)
    {
        DateService dateService = new DateService(workLog.getCreatedAt());
        String date = dateService.toFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        Response<JSONObject> result = Webb.create().post(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic "+encoding)
                .body("{\"comment\":\""+workLog.getDescription()+"\",\"started\":\""+date+"\",\"timeSpent\":\""+ workLog.getDuration() +"m\"}")
                .asJsonObject();
        JSONObject res = result.getBody();

        System.out.println(res.toString());
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserController {
    public List<Map> list = new ArrayList<Map>();

    public void create(Map<String, String> params) {
        String name = params.get("name");
        String age = params.get("age");
        new DataBase().execute("insert into user (name, age) values ('" + name + "', '" + age + "' );");
    }

    public void search(Map<String, String> params) {
        StringBuilder query = new StringBuilder("select * from user");
        List wheres = new ArrayList();
        if (params.get("name") != "") {
            wheres.add("name = '" + params.get("name") + "'");
        }
        if (params.get("age") != "") {
            wheres.add("age <= " + params.get("age"));
        }
        if (wheres.size() != 0) {
            query.append(" where " + String.join(" AND ", wheres));
        }
        query.append(";");
        list = new DataBase().find(query.toString());
    }

}
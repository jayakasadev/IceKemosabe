import extData.LoadExtBarrowIce;
import extData.LoadExtNOAA;
import org.json.JSONException;

/**
 * Created by kasa2 on 4/23/2016.
 */
public class BarrowIceTest {
    public static void main(String[] args){
        LoadExtBarrowIce ice = LoadExtBarrowIce.getInstance();

        ice.getData();
    }
}

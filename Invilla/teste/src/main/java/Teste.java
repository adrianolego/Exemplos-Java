import java.util.HashMap;
import java.util.Map;

public class Teste {

  static int sockMerchant(int n, int[] ar) {

    HashMap<Integer, Integer> mapaCores = new HashMap<>();
    for (int i = 0; i < ar.length; i++) {
      if (!mapaCores.containsKey(ar[i])) {
        mapaCores.put(ar[i], 1);
      } else {
        mapaCores.put(ar[i], mapaCores.get(ar[i]) + 1);
      }
    }

    int totalPares = 0;
    for (Map.Entry<Integer, Integer> map : mapaCores.entrySet()) {
      if (map.getValue() >= 2) {
        totalPares += map.getValue() / 2;
      }
    }
    return totalPares;
  }

}

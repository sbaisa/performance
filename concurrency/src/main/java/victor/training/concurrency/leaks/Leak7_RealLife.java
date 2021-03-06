package victor.training.concurrency.leaks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("leak7")
public class Leak7_RealLife {
    // ANATHEMA: Never bake your own cache
    private static Map<String, Integer> smallEntriesCantHurt = new HashMap<>();

	@GetMapping
	public String test() {
		for (int i = 0; i < 1_000_000; i++) {
			// simulate a lot more load
	    	smallEntriesCantHurt.put(UUID.randomUUID().toString(), 1);
		}
		return "real-life case: no more obvious suspect 20MB int[]";
	}
}

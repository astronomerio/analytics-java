package sample;

import com.segment.analytics.Analytics;
import com.segment.analytics.messages.TrackMessage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
  public static void main(String... args) throws Exception {
    final BlockingFlush blockingFlush = BlockingFlush.create();

    // https://segment.com/segment-engineering/sources/test-java/debugger
<<<<<<< HEAD
    final Analytics analytics = Analytics.builder("xemyw6oe3n") //
        .plugin(blockingFlush.plugin())
        .plugin(new LoggingPlugin())
=======
    final Analytics analytics = Analytics.builder("M22kc6xTTPyKmpfFg") //
        .log(STDOUT) //
        .callback(CALLBACK) //
>>>>>>> e2cddb8877a5f6ab51bdfebc1451266e22920136
        .build();

    final String userId = System.getProperty("user.name");
    final UUID anonymousId = UUID.randomUUID();

    final AtomicInteger count = new AtomicInteger();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("count", count.incrementAndGet());
        analytics.enqueue(TrackMessage.builder("Java Test") //
            .properties(properties) //
            .anonymousId(anonymousId) //
            .userId(userId));
      }
    }

    analytics.flush();
    blockingFlush.block();
    analytics.shutdown();
  }
}

package io.quarkus.camel.core.deployment.devmode;

import io.quarkus.deployment.devmode.HotReplacementContext;
import io.quarkus.deployment.devmode.HotReplacementSetup;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CamelHotReplacementSetup implements HotReplacementSetup {

    private static final long TWO_SECS = TimeUnit.SECONDS.toMillis(2);

    @Override
    public void setupHotDeployment(HotReplacementContext context) {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    context.doScan();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, TWO_SECS, TWO_SECS);
    }

}

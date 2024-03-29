package io.quarkus.camel.core.runtime;

import io.quarkus.camel.core.runtime.graal.JaxbDisabled;
import io.quarkus.camel.core.runtime.graal.XmlDisabled;
import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import java.util.List;

public class CamelConfig {

    @ConfigRoot(name = "camel", phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
    public static class BuildTime {

        /**
         * Uri to an xml containing camel routes to be loaded and initialized at build time.
         */
        @ConfigItem
        public List<String> routesUris;

        /**
         * Defer Camel context initialization phase until runtime.
         */
        @ConfigItem(defaultValue = "false")
        public boolean deferInitPhase;

        /**
         * Camel jaxb support is enabled by default, but in order to trim down the size of applications, it is possible
         * to disable jaxb support at runtime. This is useful when routes at loaded at build time and thus the camel
         * route model is not used at runtime anymore.
         *
         * @see JaxbDisabled
         */
        @ConfigItem(defaultValue = "false")
        public boolean disableJaxb;

        /**
         * Disable XML support in various parts of Camel. Because xml parsing using xerces/xalan libraries can consume a
         * lot of code space in the native binary (and a lot of cpu resources when building), this allows to disable
         * both libraries.
         *
         * @see XmlDisabled
         */
        @ConfigItem(defaultValue = "false")
        public boolean disableXml;
    }

    @ConfigRoot(name = "camel", phase = ConfigPhase.RUN_TIME)
    public static class Runtime {

        /**
         * Dump loaded routes when starting
         */
        @ConfigItem(defaultValue = "false")
        public boolean dumpRoutes;
    }

}

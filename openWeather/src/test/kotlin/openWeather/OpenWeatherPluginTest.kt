/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package openWeather

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'openWeather.greeting' plugin.
 */
class OpenWeatherPluginTest {
    @Test fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("openWeather.greeting")

        // Verify the result
        assertNotNull(project.tasks.findByName("greeting"))
    }
}

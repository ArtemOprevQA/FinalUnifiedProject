The project includes tasks for testing the REST API of an internal corporate service and testing the functionality of the Libertex Terminal user interface for the BVI broker. Both tests are conducted in a pre-production environment.

To run the UI test in the Run/Debug Configurations of the Gradle project, you need to enter:
:test --tests com.libertex.aqa.mixqa.practictask.ui.LibertexTerminalTest

To run the API test in the Run/Debug Configurations of the Gradle project, you need to enter:
:test --tests com.libertex.aqa.mixqa.practictask.api.GetBankDetailsApiTest

You can configure the run parameters in the config.properties file.
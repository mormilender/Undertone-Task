package similarityTesting.stepDefinition;

import java.util.Arrays;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utillities.ArrayUtils;

public class EdgeCaseSimilarityTest {

    private List<List<String>> rows;
    private SoftAssertions softAssertions = new SoftAssertions();

    @Given("^I have have two different edge case arrays$")
    public void getData(DataTable table) {
        rows = table.asLists(String.class);
    }

    @When("^I send the different edge case arrays to the areSimilar function$")
    public void invokeSimilarityFunction() {
        for (List<String> row : rows) {
            int[] arr1 = null;
            int[] arr2 = null;
            if (row.get(0) != null) arr1 = Arrays.stream(row.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
            if (row.get(1) != null)
                arr2 = Arrays.stream(row.get(1).split(",")).mapToInt(Integer::parseInt).toArray();
            softAssertions
                    .assertThat(ArrayUtils.areSimilar(arr1, arr2))
                    .withFailMessage("similarity function failed for this two edge case arrays " +
                            row.get(0) + " and " + row.get(1))
                    .isFalse();
        }

    }

    @Then("^All results should be false with no exception thrown")
    public void assertResults() {
        softAssertions.assertAll();
    }
}

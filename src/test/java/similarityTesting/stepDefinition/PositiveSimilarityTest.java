package similarityTesting.stepDefinition;

import java.util.Arrays;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utillities.ArrayUtils;

public class PositiveSimilarityTest {

    private List<List<String>> rows;
    private SoftAssertions softAssertions = new SoftAssertions();

    @Given("^I have have two similar arrays$")
    public void getData(DataTable table) {
        rows = table.asLists(String.class);
    }

    @When("^I send the similar arrays to the areSimilar function$")
    public void invokeSimilarityFunction() {
        for (List<String> row: rows){
            int[] arr1 = Arrays.stream(row.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(row.get(1).split(",")).mapToInt(Integer::parseInt).toArray();
            softAssertions
                    .assertThat(ArrayUtils.areSimilar(arr1, arr2))
                    .withFailMessage("similarity function failed for this two similar arrays " +
                            row.get(0) + " and " + row.get(1))
                    .isTrue();
        }

    }

    @Then("^All results should be true$")
    public void assertResults() {
        softAssertions.assertAll();
    }
}

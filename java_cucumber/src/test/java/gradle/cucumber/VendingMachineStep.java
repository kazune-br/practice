package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class VendingMachineStep {

    private VendingMachine vm;

    @Given("自動販売機がある")
    public void 自動販売機がある() {
        vm = new VendingMachine();
    }


    @When("^(\\d+)円を入金$")
    public void 円を入金(int money) throws Throwable {
        vm.insert(money);
    }

    @Then("^(\\d+)円が入金されている$")
    public void 円が入金されている(int money) throws Throwable {
        assertEquals(money, vm.currentMoney());
    }

    @When("^\"([^\"]*)\"を(\\d+)個補充$")
    public void を個補充(String drinkName, int monsterDrinkCount) throws Throwable {
        vm.add(drinkName, monsterDrinkCount);

    }

    @Then("^\"([^\"]*)\"の在庫が(\\d+)個$")
    public void の在庫が個(String drinkName, int monsterDrinkCount) throws Throwable {
        assertEquals(monsterDrinkCount, vm.currentMonsterDrinkCount(drinkName));

    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CadAssistant {
    List<Deal> deals = new ArrayList<>();

    public CadAssistant() {
        fillDeals(deals);
    }


    private void fillDeals(List<Deal> deals) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            deals.add(new Deal(random.nextInt(5) + 10,
                    random.nextInt(5) + 10,
                    random.nextInt(2500000) + 5000000));
        }
    }

    public String printDeals(int pricePerSquareMeter) {
        return dealsToString(getFilterDeals(pricePerSquareMeter));
    }

    private boolean isFair(int pricePerSquareMeter, Deal deal) {
        int truePrice = pricePerSquareMeter * deal.getLength() * deal.getWidth();
        return truePrice < deal.getPrice();
    }

    private List<Deal> getFilterDeals(int pricePerSquareMeter) {
        Function<List<Deal>, List<Deal>> function = (a) -> deals.stream()
                .filter(deal -> isFair(pricePerSquareMeter, deal))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return function.apply(deals);
    }

    private String dealsToString(List<Deal> trueDeals) {
        StringBuilder sb = new StringBuilder();
        for (Deal deal : trueDeals) {
            sb.append(deal.toString()).append("\n");
        }
        return sb.toString();
    }

}

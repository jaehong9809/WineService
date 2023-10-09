package WineService.domain.web;

import WineService.domain.item.Alcohol;
import WineService.domain.item.AlcoholRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class AlcoholController {
    // thymeleaf, bootstrap, db

    private final AlcoholRepository alcoholRepository;

    @GetMapping
    public String items(Model model) {
        List<Alcohol> all = alcoholRepository.findAll();
        model.addAttribute("alcohols", all);
        return "basic/items";
    }

}

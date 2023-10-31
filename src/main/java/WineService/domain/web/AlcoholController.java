package WineService.domain.web;

import WineService.domain.item.Alcohol;
import WineService.domain.item.AlcoholRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
/*
기능 1. 주류 전체 보기
기능 2. 주류 추가
기능 3. 주류 수정
기능 4. 주류 삭제
 */
@Controller
@RequestMapping("/")
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

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {
        Alcohol al = alcoholRepository.findById(itemId);
        model.addAttribute("item", al);
        return "/basic/item";
    }
    @GetMapping("add")
    public String add() {
        return "/basic/addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("item") Alcohol alcohol,
                       RedirectAttributes redirectAttributes) {
        Alcohol al = alcoholRepository.save(alcohol);
        redirectAttributes.addAttribute("itemId", al.getId());
        return "redirect:/{itemId}";

    }

}

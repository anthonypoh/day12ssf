package sg.edu.nus.iss.d12lecture.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sg.edu.nus.iss.d12lecture.model.Num;

@Controller
@RequestMapping("/numbers")
public class IndexController {

  @GetMapping(produces = { "text/html" })
  public String index(@RequestParam(required = true) Integer num, Model Nums) {
    List<Num> listOfNums = new ArrayList<>();
    ArrayList<Integer> listOfRandomNumbers = new ArrayList<Integer>();

    for (int i = 0; i < 31; i++) listOfRandomNumbers.add(i);
    Collections.shuffle(listOfRandomNumbers);

    for (Integer i = 0; i < num; i++) {
      Num newNum = new Num(
        listOfRandomNumbers.get(i),
        "number" + listOfRandomNumbers.get(i) + ".jpg"
      );
      listOfNums.add(newNum);
    }

    Nums.addAttribute("listOfNums", listOfNums);
    return "numbers";
  }
}

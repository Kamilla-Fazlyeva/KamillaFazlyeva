package hwapi.service;

import com.google.gson.Gson;
import hwapi.builder.YandexSpellerRequest;
import hwapi.dto.SpellResult;

import java.util.HashMap;
import java.util.Map;

import static hwapi.enums.YandexSpellerConstants.*;
import static hwapi.service.URI.*;

public class YandexSpellerService {

    public SpellResult[] getCheckText(YandexSpellerRequest request) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, request.getText());
        params.put(PARAM_LANG, request.getLang());
        params.put(PARAM_OPTIONS, request.getOptions());

        return new Gson().fromJson(new CommonService()
                   .getWithParams(CHECK_TEXT, params)
                   .getBody().asString(), SpellResult[].class);
    }

    public SpellResult[][] getCheckTexts(String[] texts) {
        Map<String, Object> params = new HashMap<>();
        params.put(PARAM_TEXT, texts);

        return new Gson().fromJson(new CommonService()
                .getWithParams(CHECK_TEXTS, params)
                .getBody().asString(), SpellResult[][].class);
    }
}

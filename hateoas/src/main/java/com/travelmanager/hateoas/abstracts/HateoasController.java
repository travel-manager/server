package com.travelmanager.hateoas.abstracts;

import com.google.gson.Gson;
import com.travelmanager.hateoas.annotations.WrapWithLink;
import com.travelmanager.hateoas.utils.HateoasResponse;
import com.travelmanager.hateoas.utils.HateoasUtil;
import org.assertj.core.util.Lists;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract RestController with basic http-requests responses at rest level 3
 *
 * @author lfb0801
 */
public abstract class HateoasController<T extends ResourceSupport, Identifier extends Serializable> {

    Gson gson = new Gson();

    private HateoasService<T, Identifier> service;

    public HateoasController(HateoasService<T, Identifier> _service) {
        this.service = _service;
    }

    /**
     * Use this method to return the classname of the instance.
     *
     * @return class of the instance.
     */
    public abstract Class<? extends HateoasController<T, Identifier>> getClazz();

    public abstract Class<? extends ResourceSupport> getType();

    /**
     * Retrieve the options for this rest services.
     *
     * @return a header with allowed options.
     */
    @RequestMapping(value = "/", method = RequestMethod.OPTIONS)
    public HttpEntity<String> options() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("allow", "HEAD,GET,PUT,DELETE,POST,OPTIONS");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/{entity}")
    @WrapWithLink
    public HttpEntity<HateoasResponse> create(@PathVariable T entity) {
        service.create(entity);
        return HateoasUtil.build(entity);
    }

    @GetMapping(value = "/")
    @WrapWithLink
    public HttpEntity<HateoasResponse> getAll(final HttpServletRequest request) {
        final List<T> entities = Lists.newArrayList(service.readAll());
        final List<HateoasResponse> responses = new ArrayList<>(entities.size());
        responses.addAll(entities.stream().map(entity -> HateoasUtil.toHateoas(
                entity,
                WrapWithLink.Type.SELF.link(request, "/" + entity.getId()),
                WrapWithLink.Type.POST.link(request, ""),
                WrapWithLink.Type.UPDATE.link(request, "/" + entity.getId()),
                WrapWithLink.Type.DELETE.link(request, "/" + entity.getId())
        )).collect(Collectors.toList()));
        return HateoasUtil.build(responses);    }

    @GetMapping(value = "/{id}")
    @WrapWithLink
    public HttpEntity<HateoasResponse> get(@PathVariable Identifier id) {
        final T result = service.read(id);
        return HateoasUtil.build(result);
    }

    @PutMapping(value = "/")
    @WrapWithLink
    public HttpEntity<HateoasResponse> update(@RequestBody String entityString) {
        T entity = gson.fromJson(entityString, (Type) this.getType());
        service.update(entity);
        return HateoasUtil.build(entity);
    }

    @DeleteMapping(value = "/{id}")
    @WrapWithLink
    public HttpEntity<HateoasResponse> delete(@PathVariable("id") Identifier id) {
        service.delete(service.read(id));
        return HateoasUtil.build(id);
    }

    private int next(final String string, final Integer number) {
        int value = Integer.valueOf(string) + 1;
        return Math.min(value, number);
    }

    private int prev(final String string, final Integer number) {
        int value = Integer.valueOf(string) - 1;
        return Math.max(Math.min(number, 1), value);
    }
}
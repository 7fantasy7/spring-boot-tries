package by.botyanov.examis.util;

import by.botyanov.examis.entity.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class JsonPage<T> extends org.springframework.data.domain.PageImpl<T> {

    public JsonPage(final List<T> content, final Pageable pageable, final long total) {
        super(content, pageable, total);
    }

    public JsonPage(final List<T> content) {
        super(content);
    }

    public JsonPage(final Page<T> page, final Pageable pageable) {
        super(page.getContent(), pageable, page.getTotalElements());
    }

    @JsonView(View.Summary.class)
    public int getTotalPages() {
        return super.getTotalPages();
    }

    @JsonView(View.Summary.class)
    public long getTotalElements() {
        return super.getTotalElements();
    }

    @JsonView(View.Summary.class)
    public boolean hasNext() {
        return super.hasNext();
    }

    @JsonView(View.Summary.class)
    public boolean isLast() {
        return super.isLast();
    }

    @JsonView(View.Summary.class)
    public boolean hasContent() {
        return super.hasContent();
    }

    @JsonView(View.Summary.class)
    public List<T> getContent() {
        return super.getContent();
    }
}
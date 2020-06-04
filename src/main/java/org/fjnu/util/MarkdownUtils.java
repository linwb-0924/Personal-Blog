package org.fjnu.util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * @author wb_Lin
 * @create 2020-06-04 15:03
 */
public class MarkdownUtils {
    public static  String marktohtml(String content){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}

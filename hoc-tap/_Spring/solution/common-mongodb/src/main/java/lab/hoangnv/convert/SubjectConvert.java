package lab.hoangnv.convert;

import lab.hoangnv.client.SubjectRequestCli;
import lab.hoangnv.entity.SubjectDocument;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubjectConvert implements Converter<SubjectDocument, SubjectRequestCli> {

    @Override
    public SubjectRequestCli convert(SubjectDocument source) {
        String authorName = (source.getAuthor() != null)?source.getAuthor().getName():null;
        String nxbName = (source.getNxb() != null)?source.getNxb().getName():null;

        return SubjectRequestCli.builder()
                .id(source.getId())
                .name(source.getName())
                .author(authorName)
                .nxb(nxbName)
                .grade(source.getGrade())
                .content(source.getContent())
                .comments(source.getComments())
                .build();
    }
}

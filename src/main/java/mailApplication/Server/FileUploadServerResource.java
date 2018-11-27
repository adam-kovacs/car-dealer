package mailApplication.Server;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.restlet.data.LocalReference;
import org.restlet.data.MediaType;
import org.restlet.ext.fileupload.RestletFileUpload;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.io.*;
import java.util.List;

public class FileUploadServerResource
        extends ServerResource {

    @Get
    public Representation getForm() {
        Representation mailFtl = new ClientResource("file://c:/Onbox/Learning/Apps/target/classes/UploadForm.ftl").get();
        return new TemplateRepresentation(mailFtl, MediaType.TEXT_HTML);
    }

    @Put("txt")
    public String upload(Representation input) throws FileUploadException, IOException {
        RestletFileUpload fileUpload = new RestletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = fileUpload.parseRepresentation(input);

        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                System.out.println(fileItem.getFieldName() + " = " + fileItem.getString());
            } else {
                Representation attachment = new InputRepresentation(fileItem.getInputStream());
                attachment.write(System.out);
             }
        }
        return "Mail Updated! Image Saved.";
    }

}

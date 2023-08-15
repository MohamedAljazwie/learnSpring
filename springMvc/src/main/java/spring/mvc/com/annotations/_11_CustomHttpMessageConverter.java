package spring.mvc.com.annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
@RestController
@RequestMapping("customHttpMessageConverter")
public class _11_CustomHttpMessageConverter {
	private List<Report> reports = new ArrayList<>();

	@RequestMapping(value = "/reports", method = RequestMethod.POST, consumes = "text/report",produces = "text/report")
	@ResponseBody
	public Report handleRequest(@RequestBody Report report) {
		report.setId(reports.size() + 1);
		reports.add(report);
		return  report;
	}

	@RequestMapping(value = "/reports/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Report reportById(@PathVariable("id") int reportId) {
		if (reportId > reports.size()) {
			throw new RuntimeException("No found for the id :" + reportId);
		}
		return reports.get(reportId - 1);
	}

	public static class Report {
		private int id;
		private String reportName;
		private String content;

		public String getReportName() {
			return reportName;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setReportName(String reportName) {
			this.reportName = reportName;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		@Override
		public String toString() {
			return "Report{" + "id=" + id + ", reportName='" + reportName + '\'' + ", content='" + content + '\'' + '}';
		}
	}

	public static class ReportConverter extends AbstractHttpMessageConverter<Report> {

		public ReportConverter() {
			super(new MediaType("text", "report"));
		}

		@Override
		protected boolean supports(Class<?> clazz) {
			return Report.class.isAssignableFrom(clazz);
		}

		@Override
		protected Report readInternal(Class<? extends Report> clazz, HttpInputMessage inputMessage)
				throws IOException, HttpMessageNotReadableException {
			String requestBody = toString(inputMessage.getBody());
			int i = requestBody.indexOf("\\n");
			if (i == -1) {
				throw new HttpMessageNotReadableException("No first line found");
			}

			String reportName = requestBody.substring(0, i).trim();
			String content = requestBody.substring(i+1).trim();

			Report report = new Report();
			report.setReportName(reportName);
			report.setContent(content);
			return report;
		}

		@Override
		protected void writeInternal(Report report, HttpOutputMessage outputMessage)
				throws IOException, HttpMessageNotWritableException {
			try {
				OutputStream outputStream = outputMessage.getBody();
				String body = report.getReportName() + "\n" + report.getContent();
				outputStream.write(body.getBytes());
				outputStream.close();
			} catch (Exception e) {
			}
		}

		private  static String toString(InputStream inputStream) {
			Scanner scanner = new Scanner(inputStream, "UTF-8");
			return scanner.useDelimiter("\\A").next();
		}
	}
}

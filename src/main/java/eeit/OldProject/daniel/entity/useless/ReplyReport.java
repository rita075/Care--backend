package eeit.OldProject.daniel.entity.useless;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eeit.OldProject.daniel.entity.reply.Reply;
import eeit.OldProject.steve.Entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"user","reply","reportType","resolver"})
@Entity
@Table(name = "reply_report", schema = "final")
public class ReplyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReplyReportId")
    private Long replyReportId;

    @Column(name = "Reason", length = 400)
    private String reason;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "IsResolved")
    private Boolean isResolved;

    @Column(name = "ResolvedAt")
    private LocalDateTime resolvedAt;

    @Column(name = "ResolutionNote", length = 400)
    private String resolutionNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    @JsonIgnoreProperties("replyReports")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReplyId")
    @JsonIgnoreProperties("reports")
    private Reply reply;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportTypeId")
    @JsonIgnoreProperties({"commentReports","postReports","replyReports"})
    private ReportType reportType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResolvedBy")
    @JsonIgnoreProperties({"commentReports","postReports","replyReports"})
    private User resolver;
}

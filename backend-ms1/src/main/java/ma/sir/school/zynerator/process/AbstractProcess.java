package ma.sir.school.zynerator.process;

import ma.sir.school.zynerator.audit.AuditBusinessObject;

public interface AbstractProcess<I extends AbstractProcessInput, K extends AbstractProcessOutput, T extends AuditBusinessObject> {
    Result<I, K, T> execute(I input);
}

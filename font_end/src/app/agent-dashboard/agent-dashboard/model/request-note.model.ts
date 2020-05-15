export class RequestNote {
  public requestId: string;
  public note: string;

  constructor(requestId: string, note: string) {
    this.requestId = requestId;
    this.note = note;
  }
}

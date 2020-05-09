export class RequestGetAgentRequests {
  public start: string;
  public max: string;
  public column: string;
  public key: string;
  constructor(start: string, max: string, column: string, key: string) {
    this.start = start;
    this.max = max;
    this.column = column;
    this.key = key;
  }
}

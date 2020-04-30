export class History {
  private id: string;
  private date: string;
  private location: string;
  private note: string;
  private patient_description: string;
  private reffered_by: string;
  private user_id: string;


  /**
   * Getter $id
   * @return {string}
   */
  public get $id(): string {
    return this.id;
  }

  /**
   * Getter $date
   * @return {string}
   */
  public get $date(): string {
    return this.date;
  }

  /**
   * Getter $location
   * @return {string}
   */
  public get $location(): string {
    return this.location;
  }

  /**
   * Getter $note
   * @return {string}
   */
  public get $note(): string {
    return this.note;
  }

  /**
   * Getter $patient_description
   * @return {string}
   */
  public get $patient_description(): string {
    return this.patient_description;
  }

  /**
   * Getter $reffered_by
   * @return {string}
   */
  public get $reffered_by(): string {
    return this.reffered_by;
  }

  /**
   * Getter $user_id
   * @return {string}
   */
  public get $user_id(): string {
    return this.user_id;
  }

  /**
   * Setter $id
   * @param {string} value
   */
  public set $id(value: string) {
    this.id = value;
  }

  /**
   * Setter $date
   * @param {string} value
   */
  public set $date(value: string) {
    this.date = value;
  }

  /**
   * Setter $location
   * @param {string} value
   */
  public set $location(value: string) {
    this.location = value;
  }

  /**
   * Setter $note
   * @param {string} value
   */
  public set $note(value: string) {
    this.note = value;
  }

  /**
   * Setter $patient_description
   * @param {string} value
   */
  public set $patient_description(value: string) {
    this.patient_description = value;
  }

  /**
   * Setter $reffered_by
   * @param {string} value
   */
  public set $reffered_by(value: string) {
    this.reffered_by = value;
  }

  /**
   * Setter $user_id
   * @param {string} value
   */
  public set $user_id(value: string) {
    this.user_id = value;
  }


}

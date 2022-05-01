export enum ApiCode {
  Success = 200,
  Fail = 100
}

export class Page {
  pageLimit!: number;
  pageIndex!: number;
  total?: number;
  order?: string;
}

export class ApiResult<T> {
  page!: Page | null;
  msg!: string;
  apiCode!: ApiCode;
  result!: T;
}

export const enum RequestUrlEnum {
  wxUserGetList = '/wxAccount/getWxAccountList'
}

export class AuthToken{
  token!: string;
}

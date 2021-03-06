$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Upload_Meter_Read_and_Generate_Bill.feature");
formatter.feature({
  "line": 1,
  "name": "Upload Meter Read and Generate bill",
  "description": "",
  "id": "upload-meter-read-and-generate-bill",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Upload meter read using batch run \u0026 generate Bill",
  "description": "",
  "id": "upload-meter-read-and-generate-bill;upload-meter-read-using-batch-run-\u0026-generate-bill",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@MeterRead"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "Open browser \"Chrome\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Login to CCB under \"%ENV%\" environment with user as \"username\" and password as \"password\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Ensure user will be landed to \"Control Central\" after successful login",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "Select \"Account ID\" from \"Search BY\" drop down list under \"Control Central\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Enter \"7737321685\" in the Account ID input field and click on Search button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Navigate to below list from top to bottom in order to reach \"MR Upload Staging\" page",
  "rows": [
    {
      "comments": [
        {
          "line": 10,
          "value": "#---------------------------------------------------------------"
        },
        {
          "line": 11,
          "value": "# | Link               |"
        },
        {
          "line": 12,
          "value": "#---------------------------------------------------------------"
        }
      ],
      "cells": [
        "Menu"
      ],
      "line": 13
    },
    {
      "cells": [
        "Meter Read"
      ],
      "line": 14
    },
    {
      "cells": [
        "MR Upload Staging"
      ],
      "line": 15
    },
    {
      "cells": [
        "Add"
      ],
      "line": 16
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Enter below values in \"MR Upload Staging\" page",
  "rows": [
    {
      "comments": [
        {
          "line": 18,
          "value": "#-----------------------------------------------------------------"
        },
        {
          "line": 19,
          "value": "# | Field              |       Values             |"
        },
        {
          "line": 20,
          "value": "#-----------------------------------------------------------------"
        }
      ],
      "cells": [
        "BADGE NUMBER",
        "EC0500"
      ],
      "line": 21
    },
    {
      "cells": [
        "DATE",
        "2019-05-09"
      ],
      "line": 22
    },
    {
      "cells": [
        "TIME",
        "12:57AM"
      ],
      "line": 23
    },
    {
      "cells": [
        "MR SOURCE",
        "Meter reader 19-19"
      ],
      "line": 24
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Select \"USE ON BILL\" check box",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Fill the \"Meter Read\" as mentioned below ::",
  "rows": [
    {
      "comments": [
        {
          "line": 27,
          "value": "#--------------------------------------------------------------------------------------------------------------"
        },
        {
          "line": 28,
          "value": "# |     SEQUENCE       |       READ TYPE          |  UNIT OF MEASURE | TIME OF USE       |   REGISTER READING  |"
        },
        {
          "line": 29,
          "value": "#--------------------------------------------------------------------------------------------------------------"
        }
      ],
      "cells": [
        "1",
        "Regular",
        "Kilowatt-Hours",
        "On peak",
        "450"
      ],
      "line": 30
    },
    {
      "cells": [
        "2",
        "Regular",
        "Kilowatt-Hours",
        "Off peak",
        "250"
      ],
      "line": 31
    },
    {
      "cells": [
        "3",
        "Regular",
        "Kilowatt-Hours",
        "Shoulder Peak",
        "550"
      ],
      "line": 32
    },
    {
      "cells": [
        "4",
        "Regular",
        "Kilowatt",
        "On peak",
        "250"
      ],
      "line": 33
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "Click on \"Save\" button in \"MR Upload Staging\" page",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Navigate to below list from top to bottom in order to reach \"Batch Job Submission\" page",
  "rows": [
    {
      "comments": [
        {
          "line": 36,
          "value": "#---------------------------------------------------------------"
        },
        {
          "line": 37,
          "value": "# | Link               |"
        },
        {
          "line": 38,
          "value": "#---------------------------------------------------------------"
        }
      ],
      "cells": [
        "Menu"
      ],
      "line": 39
    },
    {
      "cells": [
        "Tools"
      ],
      "line": 40
    },
    {
      "cells": [
        "Batch Job Submission"
      ],
      "line": 41
    },
    {
      "cells": [
        "Add"
      ],
      "line": 42
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "Enter below values in \"Batch Job Submission\" page",
  "rows": [
    {
      "comments": [
        {
          "line": 44,
          "value": "#-----------------------------------------------------------------"
        },
        {
          "line": 45,
          "value": "# | Field              |       Values             |"
        },
        {
          "line": 46,
          "value": "#-----------------------------------------------------------------"
        }
      ],
      "cells": [
        "BATCH CODE",
        "MUP1"
      ],
      "line": 47
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "Click on \"Save\" button in \"Batch Job Submission\" page",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "The value of \"BATCH JOB STATUS\" is displayed as \"Ended\" under \"Batch Job Submission\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 50,
  "name": "Click on \"Batch Control Context Menu - Batch Code\" and then select \"Go To Batch Run Tree\" in \"Batch Job Submission\" page",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Chrome",
      "offset": 14
    }
  ],
  "location": "POC_Step_Definition.open_browser(String)"
});
formatter.result({
  "duration": 5281494167,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "%ENV%",
      "offset": 20
    },
    {
      "val": "username",
      "offset": 53
    },
    {
      "val": "password",
      "offset": 80
    }
  ],
  "location": "POC_Step_Definition.login_to_CCB_under_environment_with_user_as_and_password_as(String,String,String)"
});
formatter.result({
  "duration": 13689743958,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Control Central",
      "offset": 31
    }
  ],
  "location": "POC_Step_Definition.ensure_user_will_be_landed_to_after_successful_login(String)"
});
formatter.result({
  "duration": 4796138448,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Account ID",
      "offset": 8
    },
    {
      "val": "Search BY",
      "offset": 26
    },
    {
      "val": "Control Central",
      "offset": 59
    }
  ],
  "location": "POC_Step_Definition.select_from_drop_down_list_under(String,String,String)"
});
formatter.result({
  "duration": 7521962525,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "7737321685",
      "offset": 7
    }
  ],
  "location": "POC_Step_Definition.enter_in_the_Account_ID_input_field_and_click_on_Search_button(String)"
});
formatter.result({
  "duration": 10083040182,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MR Upload Staging",
      "offset": 61
    }
  ],
  "location": "POC_Step_Definition.navigate_to_below_list_from_top_to_botton_in_order_to_reach_page(String,String\u003e)"
});
formatter.result({
  "duration": 11240305101,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "MR Upload Staging",
      "offset": 23
    }
  ],
  "location": "POC_Step_Definition.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 5030928921,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "USE ON BILL",
      "offset": 8
    }
  ],
  "location": "POC_Step_Definition.select_check_box(String)"
});
formatter.result({
  "duration": 447167211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Meter Read",
      "offset": 10
    }
  ],
  "location": "POC_Step_Definition.fill_the_as_mentioned_below(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 4886309006,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Save",
      "offset": 10
    },
    {
      "val": "MR Upload Staging",
      "offset": 27
    }
  ],
  "location": "POC_Step_Definition.click_on_button_in_page(String,String)"
});
formatter.result({
  "duration": 7759595222,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Batch Job Submission",
      "offset": 61
    }
  ],
  "location": "POC_Step_Definition.navigate_to_below_list_from_top_to_botton_in_order_to_reach_page(String,String\u003e)"
});
formatter.result({
  "duration": 10907066386,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Batch Job Submission",
      "offset": 23
    }
  ],
  "location": "POC_Step_Definition.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 6645637604,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Save",
      "offset": 10
    },
    {
      "val": "Batch Job Submission",
      "offset": 27
    }
  ],
  "location": "POC_Step_Definition.click_on_button_in_page(String,String)"
});
formatter.result({
  "duration": 7546738970,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "BATCH JOB STATUS",
      "offset": 14
    },
    {
      "val": "Ended",
      "offset": 49
    },
    {
      "val": "Batch Job Submission",
      "offset": 63
    }
  ],
  "location": "POC_Step_Definition.the_value_of_is_displayed_as_under_page(String,String,String)"
});
formatter.result({
  "duration": 23351875810,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Batch Control Context Menu - Batch Code",
      "offset": 10
    },
    {
      "val": "Go To Batch Run Tree",
      "offset": 68
    },
    {
      "val": "Batch Job Submission",
      "offset": 94
    }
  ],
  "location": "POC_Step_Definition.click_on_and_then_select_in_page(String,String,String)"
});
formatter.result({
  "duration": 9514983510,
  "status": "passed"
});
formatter.match({
  "location": "POC_Step_Definition.close_the_browser()"
});
formatter.result({
  "duration": 15997,
  "status": "passed"
});
});
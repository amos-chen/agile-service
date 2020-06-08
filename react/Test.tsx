import React from 'react';
import { TextField } from 'choerodon-ui/pro';
import TextEditToggle from '@/components/TextEditTogglePro';

const Test = () => (
  <div>
    <TextEditToggle
      onSubmit={async (data) => {
        await new Promise((resolve) => {
          setTimeout(() => {
            resolve();
          }, 2000);
        });
        console.log(data);
      }}
      initValue="第一个"
      renderText={text => text}
    >
      <TextField style={{
        width: 100,
      }}
      />
    </TextEditToggle>
    <TextEditToggle
      onSubmit={async (data) => {
        await new Promise((resolve) => {
          setTimeout(() => {
            resolve();
          }, 2000);
        });
        console.log(data);
      }}
      initValue="第二个"
      renderText={text => text}
    >
      <TextField style={{
        width: 100,
      }}
      />
    </TextEditToggle>
  </div>
);

export default Test;
